import com.cyc.platform.admin.Application;
import com.cyc.platform.common.entity.CycAnnouncementPosition;
import com.cyc.platform.common.entity.CycInfoStick;
import com.cyc.platform.common.service.CycAnnouncementPositionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;

/**
 * Created by huzuxing on 2018/9/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CycAnnouncementPositionTest {

    @Resource
    private CycAnnouncementPositionService cycAnnouncementPositionService;

    @Test
    public void add() {
        CycAnnouncementPosition bean = new CycAnnouncementPosition();
        bean.setName("首页公告");
        Long now = Instant.now().getEpochSecond();
        bean.setTimeCreate(now.intValue());
        cycAnnouncementPositionService.add(bean);
    }

    @Test
    public void findById() {
        CycAnnouncementPosition bean = new CycAnnouncementPosition();
        bean.setId(1);
        CycAnnouncementPosition entity = cycAnnouncementPositionService.findById(bean);
        System.out.println(entity.getName());
    }

    @Test
    public void findList() {
        List<CycAnnouncementPosition> list = cycAnnouncementPositionService.findList(null);
        System.out.println(list.size());
    }
}
