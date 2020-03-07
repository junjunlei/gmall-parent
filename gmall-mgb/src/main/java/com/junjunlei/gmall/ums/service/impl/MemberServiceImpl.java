package com.junjunlei.gmall.ums.service.impl;

import com.junjunlei.gmall.ums.entity.Member;
import com.junjunlei.gmall.ums.mapper.MemberMapper;
import com.junjunlei.gmall.ums.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author junjun.lei
 * @since 2020-03-06
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
