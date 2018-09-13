
import com.cyc.platform.admin.Application;
import com.cyc.platform.common.dao.CycInfoClassifyDao;
import com.cyc.platform.common.entity.CycInfoClassify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Instant;

/**
 * Created by huzuxing on 2018/9/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CycInfoClassifyTest {

    @Resource
    private CycInfoClassifyDao cycInfoClassifyDao;

    @Test
    public void add() {
        CycInfoClassify bean = new CycInfoClassify();
        bean.setName("酒水");
        bean.setSort(1);
        bean.setParentId(7);
        Long now = Instant.now().getEpochSecond();
        bean.setTimeCreate(now.intValue());
        int result = cycInfoClassifyDao.save(bean);
        System.out.println(bean.getId());
    }

    @Test
    public void findById() {
        CycInfoClassify bean = new CycInfoClassify();
        bean.setId(4);
        CycInfoClassify entity = cycInfoClassifyDao.findById(bean);
        System.out.println(entity.getName());
    }
    @Test
    public void update() {
        CycInfoClassify bean = new CycInfoClassify();
        bean.setId(5);
        bean.setName("update66");
        bean.setParentId(6);
        Long now = Instant.now().getEpochSecond();
        bean.setTimeUpdate(now.intValue());
        cycInfoClassifyDao.update(bean);
    }
}
