package club.chenlinghong.demo.graphql.quickstart;

import club.chenlinghong.demo.graphql.model.User;
import graphql.GraphQL;
import graphql.Scalars;
import graphql.schema.GraphQLFieldDefinition;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;

import java.util.Map;

/**
 * @Description 使用resolver简单演示GraphQL api
 * @Author linghongchen
 * @Date 2019-08-21 10:28
 **/
public class GraphqlSimple {

    public static void main(String[] args) {
        /**
         * 服务端示例数据
         */
        User user = new User();
        user.setName("test");
        user.setSex("男");
        user.setIntro("测试GraphQL");

        /**
         * 定义GraphQL类型
         */
        GraphQLObjectType userType = GraphQLObjectType.newObject()
                .name("User")
                .field(GraphQLFieldDefinition.newFieldDefinition().name("name").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("sex").type(Scalars.GraphQLString))
                .field(GraphQLFieldDefinition.newFieldDefinition().name("intro").type(Scalars.GraphQLString))
                .build();

        /**
         * 定义暴露给客户端的查询 query api
         */
        GraphQLObjectType queryType = GraphQLObjectType.newObject()
                .name("userQuery")
                .field(GraphQLFieldDefinition.newFieldDefinition().type(userType).name("user").staticValue(user))
                .build();

        /**
         * 创建Schema
         */
        GraphQLSchema schema = GraphQLSchema.newSchema()
                .query(queryType)
                .build();

        /**
         * 测试输出
         */
        GraphQL graphQL = GraphQL.newGraphQL(schema).build();
        Map<String, Object> result = graphQL.execute("{user{name,sex,intro}}").getData();

        System.out.println("graph query: " + result);

    }
}
