package club.chenlinghong.demo.evosuite;

/**
 * @Description evosuite 单元测试自动生成工具类
 * @Author linghongchen
 * @Date 2019-08-28 20:19
 **/
public class EvosuiteDemo {

    /**
     * mvn  compile  evosuite:generate  -Dcores=4
     * -DmemoryInMB=8000  -DtimeInMinutesPerClass=3  -DspawnManagerPort=63040  -Dcuts=club.chenlinghong.demo
     * .evosuite.EvosuiteDemo  evosuite:export  -DtargetFolder=src/test/java/evo
     */

    public String evosuite(int id, String name) {
        if (id == 0 && "name".equals(name)) {
            return "0#name";
        }
        if (id > 0) {
            name = "name 1";
        } else {
            name = "name -1";
        }
        return "0#" + name;
    }


}
