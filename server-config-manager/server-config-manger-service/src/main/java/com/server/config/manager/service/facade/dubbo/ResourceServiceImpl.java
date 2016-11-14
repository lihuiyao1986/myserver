package com.server.config.manager.service.facade.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.server.config.manager.service.message.MessageSenderService;
import com.server.config.manager.service.normal.IResourceNormalService;
import com.server.config.manger.api.dubbo.IResourceService;
import com.server.entity.configmanager.web.req.UserRightGetReqEntity;
import com.server.entity.configmanager.web.resp.UserRight;
import com.server.entity.model.APIReqEntity;
import com.server.entity.model.APIRespEntity;
import com.server.entity.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;
import java.util.List;


/**
 * 权限相关的服务
 */
@Transactional
@Service(protocol = {"dubbo"},validation = "true")
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private IResourceNormalService resourceNormalService;

    @Qualifier("queueDestination")
    @Autowired
    private Destination destination;

    @Autowired
    private MessageSenderService senderService;

    /**
     * 查询用户的权限
     * @param params
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public APIRespEntity<List<UserRight>> queryUserRights(APIReqEntity<UserRightGetReqEntity> params) {
        String ownship = StringUtils.trimNull(params.getReqParam().getOwnShip());
        long userId = params.getReqParam().getUserId();
        List<UserRight> rights = resourceNormalService.queryUserRights("", 4, userId, StringUtils.trimNull(ownship).endsWith("00"));
        senderService.sendMessage(destination,"我发送了一条消息");
        return new APIRespEntity<List<UserRight>>(rights);
    }
}
