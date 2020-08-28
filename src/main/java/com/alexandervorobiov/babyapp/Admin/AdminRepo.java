package com.alexandervorobiov.babyapp.Admin;

import com.alexandervorobiov.babyapp.SuperUser.SuperUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AdminRepo  extends JpaRepository<Admin,Long> {
}
