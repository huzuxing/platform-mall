import com.cyc.platform.admin.Application;
import com.cyc.platform.common.entity.CycAnnouncement;
import com.cyc.platform.common.entity.CycAnnouncementPosition;
import com.cyc.platform.common.service.CycAnnouncementService;
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
public class CycAnnouncementTest {

    @Resource
    private CycAnnouncementService cycAnnouncementService;

    @Test
    public void add() {
        CycAnnouncement bean = new CycAnnouncement();
        bean.setTitle("欢迎新同学加入");
        bean.setContent("欢迎新同学加入，请注意一下事项");
        bean.setPositionId(1);
        Long now = Instant.now().getEpochSecond();
        bean.setTimeCreate(now.intValue());
        cycAnnouncementService.add(bean);
    }

    @Test
    public void findById() {
        CycAnnouncement bean = new CycAnnouncement();
        bean.setId(1);
        CycAnnouncement entity = cycAnnouncementService.findById(bean);
        System.out.println(entity.getTitle());
    }

    @Test
    public void findList() {
        CycAnnouncement bean = new CycAnnouncement();
        bean.setPositionId(2);
        List<CycAnnouncement> list = cycAnnouncementService.findList(null);
        System.out.println(list.size());
    }
}
