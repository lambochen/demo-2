package club.chenlinghong.demo.jfinal;

import com.jfinal.plugin.activerecord.Page;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/3/15 17:22
 * @Description TODO
 **/
public class BlogService {

    private Blog dao = new Blog().dao();

    public Page<Blog> paginate(int pageNo, int pageSize) {
        return dao.paginate(pageNo, pageSize, "select *", "from blog order by id desc");
    }

    public Blog findById(int id) {
        return dao.findById(id);
    }

    public void  deleteById(int id) {
        dao.deleteById(id);
    }

}
