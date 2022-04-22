package mytest.java.stream.DemoModel;

import java.util.Objects;
import java.util.Set;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-10 17:50
 * @version：
 **/
public class MemberDo {
    private Long id;
    private Set<RoleDo> roleDo;

    public MemberDo() {
    }

    public MemberDo(Long id, Set<RoleDo> roleDo) {
        this.id = id;
        this.roleDo = roleDo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<RoleDo> getRoleDo() {
        return roleDo;
    }

    public void setRoleDo(Set<RoleDo> roleDo) {
        this.roleDo = roleDo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MemberDo memberDo = (MemberDo) o;
        return Objects.equals(id, memberDo.id) &&
                Objects.equals(roleDo, memberDo.roleDo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleDo);
    }

    @Override
    public String toString() {
        return "MemberDo{" +
                "id=" + id +
                ", roleDo=" + roleDo +
                '}';
    }
}
