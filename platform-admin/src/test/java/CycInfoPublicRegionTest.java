import com.cyc.platform.admin.Application;
import com.cyc.platform.common.dao.CycInfoPublicRegionDao;
import com.cyc.platform.common.entity.CycInfoPublicRegion;
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
public class CycInfoPublicRegionTest {

    @Resource
    private CycInfoPublicRegionDao cycInfoPublicRegionDao;

    @Test
    public void add() {
        CycInfoPublicRegion bean = new CycInfoPublicRegion();
        bean.setFee(10.0);
        bean.setName("全国");
        bean.setSort(2);
        Long now = Instant.now().getEpochSecond();
        bean.setTimeCreate(now.intValue());
        cycInfoPublicRegionDao.save(bean);
    }
}
