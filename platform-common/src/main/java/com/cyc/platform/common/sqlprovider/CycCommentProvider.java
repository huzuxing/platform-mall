package com.cyc.platform.common.sqlprovider;

import com.cyc.platform.common.entity.CycComment;
import com.cyc.platform.common.utils.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.sql.SQLException;

/**
 * Created by huzuxing on 2018/9/19.
 */
public class CycCommentProvider {

    public String save(CycComment bean) throws SQLException {
        if (null == bean) {
            throw new SQLException("none data to save { " + "CycComment" + " }");
        }
        return new SQL() {
            {
                INSERT_INTO("cyc_comment");
                if (null != bean.getTopicId()) {
                    VALUES("topic_id", "#{topicId}");
                }
                if (null != bean.getTopicType()) {
                    VALUES("topic_type", "#{topicType}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getContent())) {
                    VALUES("content", "#{content}");
                }
                if (null != bean.getFromUid()) {
                    VALUES("from_uid", "#{fromUid}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getNickname())) {
                    VALUES("nickname", "#{nickname}");
                }
                if (!StringUtils.isNullOrEmpty(bean.getThumbImg())) {
                    VALUES("thumb_img", "#{thumbImg}");
                }
                if (null != bean.getPraiseCount()) {
                    VALUES("praise_count", "#{praiseCount}");
                }
                if (null != bean.getReplyCount()) {
                    VALUES("reply_count", "#{replyCount}");
                }
                if (null != bean.getIsTop()) {
                    VALUES("is_top", "#{isTop}");
                }
                if (null != bean.getIsHot()) {
                    VALUES("is_hot", "#{isHot}");
                }
                if (null != bean.getTimeCreate()) {
                    VALUES("time_create", "#{timeCreate}");
                }
            }
        }.toString();
    }
}
