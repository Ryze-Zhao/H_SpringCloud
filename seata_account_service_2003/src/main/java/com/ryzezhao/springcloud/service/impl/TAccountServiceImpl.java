package com.ryzezhao.springcloud.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ryzezhao.springcloud.mapper.TAccountMapper;
import com.ryzezhao.springcloud.entities.TAccount;
import com.ryzezhao.springcloud.service.TAccountService;

@Service
@Slf4j
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements TAccountService {
    @Override
    public boolean decrease(String userId, BigDecimal money) {
        //一些判定不写了，自行补充
        TAccount tAccount = this.getById(userId);
        log.info("------->account-service中扣减账户余额开始");
        tAccount.setResidue(tAccount.getResidue().subtract(money));
        tAccount.setUsed(tAccount.getUsed().add(money));
        boolean result = this.saveOrUpdate(tAccount);
        try { TimeUnit.SECONDS.sleep(20); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("------->account-service中扣减账户余额结束");
        return result;
    }
}
