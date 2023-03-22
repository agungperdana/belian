package com.kratonsolution.belian.user.impl.application;

import com.kratonsolution.belian.user.api.UserRoleCreateCommand;
import com.kratonsolution.belian.user.api.UserRoleData;
import com.kratonsolution.belian.user.api.UserRoleUpdateCommand;
import com.kratonsolution.belian.user.impl.orm.UserRole;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
@MapperConfig(unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRoleMapper {

    UserRoleData toData(@NonNull UserRole userRole);

    List<UserRoleData> toDataList(@NonNull List<UserRole> userRoles);

    UserRole fromCreate(@NonNull UserRoleCreateCommand command);

    UserRole fromUpdate(@NonNull UserRoleUpdateCommand command);
}
