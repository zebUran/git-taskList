package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskItemRepository extends JpaRepository<TaskItem, Integer> {
    // 特に追加メソッド不要（findAll()で一覧取得可能）
}
