package ck.tools.uid;

import org.hibernate.id.IdentifierGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;

import com.xfvape.uid.UidGenerator;

import ck.tools.SpringContextUtil;

public class IdGenerator implements IdentifierGenerator, Configurable {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        return SpringContextUtil.getBean(UidGenerator.class).getUID();
    }

}
