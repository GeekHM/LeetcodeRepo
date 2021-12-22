package mytest.java8.stream.DemoModel;

import java.util.Objects;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-10 14:38
 * @version：
 **/
public class RoleDo {
    private MemberBusinessTypeDO businessType;

    public RoleDo() {
    }

    public RoleDo(MemberBusinessTypeDO businessType) {
        this.businessType = businessType;
    }

    public MemberBusinessTypeDO getBusinessType() {
        return businessType;
    }

    public void setBusinessType(MemberBusinessTypeDO businessType) {
        this.businessType = businessType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RoleDo roleDo = (RoleDo) o;
        return Objects.equals(businessType, roleDo.businessType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessType);
    }

    @Override
    public String toString() {
        return "RoleDo{" +
                "businessType=" + businessType +
                '}';
    }
}
