package kr.ac.jejunu.model.response;

public class RemainTime {
    Integer first;
    Integer second;

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public RemainTime(RemainTimeBuilder remainTimeBuilder) {
        this.first = remainTimeBuilder.first;
        this.second = remainTimeBuilder.second;
    }

    public static class RemainTimeBuilder {
        private Integer first;
        private Integer second;

        public RemainTimeBuilder(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public RemainTime build() {
            return new RemainTime(this);
        }
    }
}
