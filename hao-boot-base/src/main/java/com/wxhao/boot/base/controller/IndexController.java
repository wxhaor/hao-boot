package com.wxhao.boot.base.controller;


import com.wxhao.boot.api.pojo.WebDefaultVO;
import com.wxhao.boot.base.properties.EnvInfoProperties;
import com.wxhao.boot.base.properties.SnowflakeProperties;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 默认页面
 *
 * @author wxhao
 * @date 2018/3/12
 */
@RestController("commonIndexController")
@RequestMapping("/")
public class IndexController {

    @Autowired
    private EnvInfoProperties envInfoProperties;
    @Autowired
    private SnowflakeProperties snowflakeProperties;

    @GetMapping("/")
    public WebDefaultVO defaultPage() {
        WebDefaultVO vo = new WebDefaultVO();
        BeanUtils.copyProperties(envInfoProperties, vo);
        BeanUtils.copyProperties(snowflakeProperties, vo);

        return vo;
    }


}
