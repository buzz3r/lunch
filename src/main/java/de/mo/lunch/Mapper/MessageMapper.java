package de.mo.lunch.Mapper;

import de.mo.lunch.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGE")
    List<Message> findAll();

    @Insert(
            "INSERT INTO message (message) " +
                    "VALUES (#{message})"
    )
    @Options(keyProperty = "id", keyColumn = "id", useGeneratedKeys = true)
    void insert(Message message);

}
