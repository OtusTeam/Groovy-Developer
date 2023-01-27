package lesson07.hw.model

import groovy.transform.ToString
import lesson07.hw.annotation.Id

@ToString(includeFields = true)
class Manager {
    @Id
    private Long no
    private String label
    private String param1

    Manager() {
    }

    Manager(String label) {
        this.label = label
    }

    Manager(Long no, String label, String param1) {
        this.no = no
        this.label = label
        this.param1 = param1
    }

    Long getNo() {
        return no;
    }

    void setNo(Long no) {
        this.no = no;
    }

    String getLabel() {
        return label;
    }

    void setLabel(String label) {
        this.label = label;
    }

    String getParam1() {
        return param1;
    }

    void setParam1(String param1) {
        this.param1 = param1;
    }
}
