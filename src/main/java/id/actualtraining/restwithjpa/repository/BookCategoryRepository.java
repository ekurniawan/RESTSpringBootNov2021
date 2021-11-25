package id.actualtraining.restwithjpa.repository;

import id.actualtraining.restwithjpa.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Long> {
}
