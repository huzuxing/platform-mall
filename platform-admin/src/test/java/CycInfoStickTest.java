import com.cyc.platform.admin.Application;
import com.cyc.platform.common.dao.CycInfoPublicRegionDao;
import com.cyc.platform.common.dao.CycInfoStickDao;
import com.cyc.platform.common.entity.CycInfoStick;
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
public class CycInfoStickTest {

    @Resource
    private CycInfoStickDao cycInfoStickDao;

    @Test
    public void add() {
        CycInfoStick bean = new CycInfoStick();
        bean.setFee(10.0);
        bean.setName("置顶1个月");
        bean.setSort(1);
        bean.setDays(7);
        Long now = Instant.now().getEpochSecond();
        bean.setTimeCreate(now.intValue());
        cycInfoStickDao.save(bean);
    }

    @Test
    public void findById() {
        CycInfoStick bean = new CycInfoStick();
        bean.setId(1);
        CycInfoStick entity = cycInfoStickDao.findById(bean);
        System.out.println(entity.getName());
    }
}
