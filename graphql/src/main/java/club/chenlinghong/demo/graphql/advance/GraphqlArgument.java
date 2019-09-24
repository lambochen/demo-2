package club.chenlinghong.demo.graphql.advance;

import club.chenlinghong.demo.graphql.model.User;
import com.google.common.collect.Lists;
import graphql.GraphQL;
import graphql.Scalars;
import graphql.schema.GraphQLArgument;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLInputObjectField;
import graphql.schema.GraphQLInputObjectType;
import graphql.schema.GraphQLInputType;
import graphql.schema.GraphQLList;
import graphql.schema.GraphQLNonNull;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description 演示如何传递参数来调用GraphQL api
 * @Author linghongchen
 * @Date 2019-08-21 11:26
 **/
public class GraphqlArgument {

    public static void main(String[] args) {
        /**
         * 服务端示例数据
         */
        List<User> userList = Lists.newArrayList();
        User user = new User();
        user.setName("test");
        user.setSex("nv");
        user.setIntro("GraphQL测试");
        userList.add(user);

        User user2 = new User();
        user2.setName("test");
        user2.setSex("nv");
        user2.setIntro("GraphQL测试");
        userList.add(user2);

        /**
         * 定义GraphQL类型
         */
        GraphQLObjectType userType = GraphQLObjectType.newObject()
                .name("user")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("sex").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("intro").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("skills").type(
                        new GraphQLList(Scalars.GraphQLString)))
                .build();

        /**
         * 定义输入类型
         */
        GraphQLInputType userInput = GraphQLInputObjectType.newInputObject()
                .name("UserInput")
                .field(GraphQLInputObjectField.newInputObjectField().name("name").type(Scalars.GraphQLString))
                .field(GraphQLInputObjectField.newInputObjectField().name("sex").type(Scalars.GraphQLString))
                .field(GraphQLInputObjectField.newInputObjectField().name("intro").type(Scalars.GraphQLString))
                .field(GraphQLInputObjectField.newInputObjectField().name("skills").type(
                        new GraphQLList(Scalars.GraphQLString)))
                .build();

        /**
         * 定义暴露给客户端的查询 query api
         */

        GraphQLObjectType queryType = GraphQLObjectType.newObject()
                .name("userQuery")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .type(userType)
                        .name("user")
                        .argument(GraphQLArgument.newArgument().name("id").type(new GraphQLNonNull(Scalars.GraphQLInt)))
                        .dataFetcher(environment -> {
                            int id = environment.getArgument("id");
                            return userList.get(id);
                        }))
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .type(new GraphQLList(userType))
                        .name("userList")
                        .dataFetcher(environment -> {
                            return userList;
                        }))
                .build();

        /**
         * 定义暴露给客户端的查询 mutation api
         */
        GraphQLObjectType mutationType = GraphQLObjectType.newObject()
                .name("userMutation")
                .field(GraphQLFieldDefinition.newFieldDefinition()
                        .type(new GraphQLList(userType))
                        .name("addUserByInput")
                        .argument(GraphQLArgument.newArgument().name("userInfo").type(new GraphQLNonNull(userInput)))
                        .dataFetcher(environment -> {
                            Map<String, Object> userInfoMap = environment.getArgument("userInfo");
                            User userInfo = new User();
                            for (String item : userInfoMap.keySet()) {
                                switch (item) {
                                    case "name":
                                        userInfo.setName(userInfoMap.get("name").toString());
                                        break;
                                    case "sex":
                                        userInfo.setSex(userInfoMap.get("sex").toString());
                                        break;
                                    case "intro":
                                        userInfo.setIntro(userInfoMap.get("intro").toString());
                                        break;
                                    case "skillList":
                                        List<String> skillList = (ArrayList<String>) userInfoMap.get("skillList");
                                        String[] skills = new String[skillList.size()];
                                        userInfo.setSkills(skillList.toArray(skills));
                                        break;
                                }
                            }
                            userList.add(userInfo);
                            return userList;
                        }))
                .build();

        /**
         * 创建Schema
         */
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .mutation(mutationType)
                .build();

        /**
         * 测试输出
         */
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();

        /**
         * 根据ID查询用户
         */
        Map<String,Object> result = graphQL.execute("{user(id:0){name,sex,intro}}").getData();
        System.out.println(result);

        /**
         * 查询用户列表
         */
        result = graphQL.execute("{userList{name,sex,intro}}").getData();
        System.out.println(result);

        /**
         * 添加用户列表
         */
        result = graphQL.execute("mutation{addUserByInput(userInfo:{name:\"test2User\",sex:\"nan\"," +
                "intro:\"test\",skillList:[\"java\",\"nodejs\"]}}){name sex intro}}").getData();
        System.out.println(result);
    }
}
