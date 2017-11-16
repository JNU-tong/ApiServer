package kr.ac.jejunu.repository.city_bus;

import kr.ac.jejunu.model.jpa.city_bus.CityBusLineInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CityBusLineInfoRepositoryTest {
    @Autowired
    private CityBusLineInfoRepository cityBusLineInfoRepository;

    @Test
    public void findOneTest() {
        String lineId = "JEB405134001";
        String lineNo = "340";
        String detailLineNo = "340-1";
        String description = "제주대-삼양초-함덕";

        CityBusLineInfo cityBusLineInfo = cityBusLineInfoRepository.findOne(lineId);

        assertThat(cityBusLineInfo.getLineId(), is(lineId));
        assertThat(cityBusLineInfo.getLineNo(), is(lineNo));
        assertThat(cityBusLineInfo.getDetailLineNo(), is(detailLineNo));
        assertThat(cityBusLineInfo.getDescription(), is(description));
    }

    @Test
    public void findOneThatNotExistTest() {
        String lineId = "NOT EXIST";

        CityBusLineInfo notExist = cityBusLineInfoRepository.findOne(lineId);

        assertThat(notExist, nullValue());
    }

    @Test
    public void findAllTest() {
        final int NUM_OF_BUS_LINE_INFO = 45;

        ArrayList<CityBusLineInfo> list = (ArrayList<CityBusLineInfo>) cityBusLineInfoRepository.findAll();

        assertThat(list.size(), is(NUM_OF_BUS_LINE_INFO));
    }

    @Test
    public void saveTest() {
        String lineId = "TEST12345678";
        String lineNo = "123";
        String detailLineNo = "123-4";
        String description = "for test";

        CityBusLineInfo cityBusLineInfo = new CityBusLineInfo();

        cityBusLineInfo.setLineId(lineId);
        cityBusLineInfo.setLineNo(lineNo);
        cityBusLineInfo.setDetailLineNo(detailLineNo);
        cityBusLineInfo.setDescription(description);

        cityBusLineInfoRepository.save(cityBusLineInfo);

        CityBusLineInfo forCheck = cityBusLineInfoRepository.findOne(lineId);

        assertThat(forCheck.getLineId(), is(lineId));
        assertThat(forCheck.getLineNo(), is(lineNo));
        assertThat(forCheck.getDetailLineNo(), is(detailLineNo));
        assertThat(forCheck.getDescription(), is(description));
    }

    @Test
    public void updateTest() {
        String lineId = "TEST12345678";
        String lineNo = "123";
        String detailLineNo = "123-4";
        String description = "for test";

        CityBusLineInfo cityBusLineInfo = new CityBusLineInfo();

        cityBusLineInfo.setLineId(lineId);
        cityBusLineInfo.setLineNo(lineNo);
        cityBusLineInfo.setDetailLineNo(detailLineNo);
        cityBusLineInfo.setDescription(description);

        cityBusLineInfoRepository.save(cityBusLineInfo);

        String updateDescription = "updated";
        cityBusLineInfo.setDescription(updateDescription);

        cityBusLineInfoRepository.save(cityBusLineInfo);

        CityBusLineInfo updatedBusLineInfo = cityBusLineInfoRepository.findOne(lineId);

        assertThat(updatedBusLineInfo.getLineId(), is(lineId));
        assertThat(updatedBusLineInfo.getDescription(), is(updateDescription));
    }

    @Test
    public void deleteTest() {
        String lineId = "TEST12345678";
        String lineNo = "123";
        String detailLineNo = "123-4";
        String description = "for test";

        CityBusLineInfo cityBusLineInfo = new CityBusLineInfo();

        cityBusLineInfo.setLineId(lineId);
        cityBusLineInfo.setLineNo(lineNo);
        cityBusLineInfo.setDetailLineNo(detailLineNo);
        cityBusLineInfo.setDescription(description);

        cityBusLineInfoRepository.save(cityBusLineInfo);

        cityBusLineInfoRepository.delete(lineId);

        CityBusLineInfo deletedBusLineInfo = cityBusLineInfoRepository.findOne(lineId);

        assertThat(deletedBusLineInfo, nullValue());
    }
}