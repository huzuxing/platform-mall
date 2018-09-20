import com.cyc.platform.api.Application;
import com.cyc.platform.common.entity.CycComment;
import com.cyc.platform.common.service.CycCommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.Instant;

/**
 * Created by huzuxing on 2018/9/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class CycCommentTest {

    @Resource
    private CycCommentService cycCommentService;

    @Test
    public void add() {
        CycComment bean = new CycComment();
        bean.setTopicId(5);
        bean.setTopicType(0);
        bean.setContent("评论测试");
        bean.setFromUid(12);
        bean.setNickname("lly");
        bean.setThumbImg("fesssssfe.png");
        Long now = Instant.now().getEpochSecond();
        bean.setTimeCreate(now.intValue());
        cycCommentService.add(bean);
    }

    @Test
    public void reply() {
        CycComment bean = new CycComment();
        bean.setTopicId(5);
        bean.setTopicType(1);
        bean.setContent("评论测试回复");
        bean.setFromUid(12);
        bean.setNickname("lly");
        bean.setThumbImg("fesssssfe.png");
        Long now = Instant.now().getEpochSecond();
        bean.setTimeCreate(now.intValue());
        cycCommentService.reply(bean, 1);
    }
}
