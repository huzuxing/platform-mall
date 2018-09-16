
import com.cyc.platform.admin.Application;
import com.cyc.platform.common.dao.CycInfoChannelDao;
import com.cyc.platform.common.entity.CycInfoChannel;
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
public class CycInfoChannelTest {

    @Resource
    private CycInfoChannelDao cycInfoChannelDao;

    @Test
    public void add() {
        CycInfoChannel bean = new CycInfoChannel();
        bean.setName("材料");
        bean.setSort(1);
        bean.setParentId(7);
        Long now = Instant.now().getEpochSecond();
        bean.setTimeCreate(now.intValue());
        bean.setIcon("fexxdfef.png");
        int result = cycInfoChannelDao.save(bean);
        System.out.println(bean.getId());
    }

    @Test
    public void findById() {
        CycInfoChannel bean = new CycInfoChannel();
        bean.setId(4);
        CycInfoChannel entity = cycInfoChannelDao.findById(bean);
        System.out.println(entity.getName());
    }
    @Test
    public void update() {
        CycInfoChannel bean = new CycInfoChannel();
        bean.setId(5);
        bean.setName("update66");
        bean.setParentId(6);
        Long now = Instant.now().getEpochSecond();
        bean.setTimeUpdate(now.intValue());
        cycInfoChannelDao.update(bean);
    }
}
