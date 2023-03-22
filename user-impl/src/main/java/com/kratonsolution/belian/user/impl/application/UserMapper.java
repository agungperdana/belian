package com.kratonsolution.belian.user.impl.application;

import com.kratonsolution.belian.user.api.UserCreateCommand;
import com.kratonsolution.belian.user.api.UserData;
import com.kratonsolution.belian.user.api.UserSettingData;
import com.kratonsolution.belian.user.impl.orm.User;
import com.kratonsolution.belian.user.impl.orm.UserSetting;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
@MapperConfig(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserData toUserData(@NonNull User user);

    List<UserData> toUserDataList(@NonNull List<User> users);

    User fromCreate(@NonNull UserCreateCommand command);

    UserSettingData toUserSetting(@NonNull UserSetting setting);

}
