package com.bobocode.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bobocode.dao.AccountDao;
import com.bobocode.model.Account;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * todo: 6. Implement method that handles PUT request with id as path variable and receives account as request body.
 * todo:    It check if account id and path variable are the same and throws {@link IllegalStateException} otherwise.
 * todo:    Then it saves received account. Configure HTTP response status code 204 - NO CONTENT
 * todo: 7. Implement method that handles DELETE request with id as path variable removes an account by id
 * todo:    Configure HTTP response status code 204 - NO CONTENT
 */

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountRestController {
    private final AccountDao accountDao;


    @GetMapping
    public List<Account> getAll() {
        return accountDao.findAll();
    }

    @GetMapping("{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountDao.findById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Account saveAccount(@RequestBody Account account) {
        return accountDao.save(account);
    }

    @PutMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Account updateAccount(@PathVariable Long id, @RequestBody Account account) {
        if (!id.equals(account.getId())) {
            throw new IllegalArgumentException();
        }
        return accountDao.save(account);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Account deleteAccount(@PathVariable Long id) {

        Account byId = accountDao.findById(id);
        return accountDao.remove(byId);
    }
}
