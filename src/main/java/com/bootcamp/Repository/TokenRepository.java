package com.bootcamp.Repository;

import com.bootcamp.Entities.User.Token;
import com.bootcamp.Entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;
@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
    @Query(value = "select * from token where email=:email",nativeQuery = true)
    public Token findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value="update token set token=:token where email=:email",nativeQuery = true)
    public void updateToken(String token,String email);

    @Transactional
    @Modifying
    @Query(value="update token set forgot_pass_token=:token where email=:email",nativeQuery = true)
    public void updateForgotPassToken(String token,String email);

    @Transactional
    @Modifying
    @Query(value="update token set token=null where email=:email",nativeQuery = true)
    public void deleteToken(String email);

    @Transactional
    @Modifying
    @Query(value="update token set forgot_pass_token=null where email=:email",nativeQuery = true)
    public void deleteForgotPassToken(String email);


}
