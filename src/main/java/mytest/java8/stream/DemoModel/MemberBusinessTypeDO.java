package mytest.java8.stream.DemoModel;

import java.util.Objects;

/**
 * @description：
 * @author: whm
 * @create: 2021-12-10 14:38
 * @version：
 **/
public class MemberBusinessTypeDO {
    private Long id;

    public MemberBusinessTypeDO() {
    }

    public MemberBusinessTypeDO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MemberBusinessTypeDO that = (MemberBusinessTypeDO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MemberBusinessTypeDO{" +
                "id=" + id +
                '}';
    }
}
