import com.cyc.platform.api.Application;
import com.cyc.platform.common.dao.CycInfoContentDao;
import com.cyc.platform.common.entity.CycInfoContacts;
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
        bean.setChannelId(1);
        CycInfoContacts contacts = new CycInfoContacts();
        contacts.setName("张三");
        contacts.setContact("13808551062");
        contacts.setProvince("四川省");
        contacts.setCity("成都市");
        contacts.setDistrict("高新区");
        contacts.setAddress("双宿双飞路");
        contacts.setTimeCreate(now.intValue());
        CycInfoContent result = cycInfoContentService.add(bean, contacts);
        System.out.println(result.getId());
    }

    @Test
    public void findById() {
        CycInfoContent bean = new CycInfoContent();
        bean.setId(5);
        CycInfoContent result = cycInfoContentService.findById(bean);
        System.out.println(result.getContent());
    }

    @Test
    public void findPage() {
        CycInfoContent bean = new CycInfoContent();
        bean.setId(5);
        CycInfoContent result = cycInfoContentService.findById(bean);
        System.out.println(result.getContent());
    }
}
