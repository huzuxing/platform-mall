import com.cyc.platform.api.Application;
import com.cyc.platform.common.dao.CycInfoContentDao;
import com.cyc.platform.common.entity.CycInfoContent;
import com.cyc.platform.common.service.CycInfoContentService;
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
public class CycInfoContentTest {

    @Resource
    private CycInfoContentService cycInfoContentService;

    @Test
    public void add() {
        CycInfoContent bean = new CycInfoContent();
        bean.setContent("测试内容");
        bean.setIsSticked(1);
        Long now = Instant.now().getEpochSecond();
        bean.setTimeCreate(now.intValue());
        bean.setTimePublish(now.intValue());
        CycInfoContent result = cycInfoContentService.add(null);
        System.out.println(result.getId());
    }

    @Test
    public void findById() {
        CycInfoContent bean = new CycInfoContent();
        bean.setId(2);
        CycInfoContent result = cycInfoContentService.findById(bean);
        System.out.println(result.getContent());
    }
}
