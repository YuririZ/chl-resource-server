package team.hulu.cms.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * @author: yurizhang
 * @date: 2020/7/14 9:22 下午
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ImageDO {
    private static final long serialVersionUID = -6126005485557632633L;
    /**
     * 自增主键
     */
    @Id
    private String id;
    /**
     * 图片名
     */
    private String name;
    /**
     * 文件扩展名
     */
    private String fileExtension;
    /**
     * 图片数据
     */
    private Binary content;
    /**
     * 创建用户
     */
    private String createUser;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新用户
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
