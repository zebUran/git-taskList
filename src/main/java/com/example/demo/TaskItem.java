package com.example.demo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task_items")
public class TaskItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "expiration_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @Column(name = "task_item", length = 50, nullable = false)
    private String taskItem;

    @Column(name = "is_completed", nullable = false)
    private Short isCompleted = 0;

    @Column(name = "is_deleted", nullable = false)
    private Short isDeleted = 0;

    @Column(name = "create_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateTime;

    @Column(name = "update_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateTime;

    // コンストラクタ（無引数）
    public TaskItem() {}

    // getter/setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getTaskItem() {
        return taskItem;
    }

    public void setTaskItem(String taskItem) {
        this.taskItem = taskItem;
    }

    public Short getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Short isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Short getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Short isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
