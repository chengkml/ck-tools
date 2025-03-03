package ck.tools.uid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xfvape.uid.UidGenerator;
import com.xfvape.uid.impl.CachedUidGenerator;
import com.xfvape.uid.worker.DisposableWorkerIdAssigner;

@Configuration
public class WorkerNodeConfig {

    @Autowired
    private WorkerNodeDao workerNodeDao;

    @Bean("disposableWorkerIdAssigner")
    public DisposableWorkerIdAssigner disposableWorkerIdAssigner() {
        DisposableWorkerIdAssigner disposableWorkerIdAssigner = new DisposableWorkerIdAssigner();
        disposableWorkerIdAssigner.setWorkerNodeDAO(workerNodeDao);
        return disposableWorkerIdAssigner;
    }

    @Bean("cachedUidGenerator")
    public UidGenerator uidGenerator(DisposableWorkerIdAssigner disposableWorkerIdAssigner) {
        CachedUidGenerator cachedUidGenerator = new CachedUidGenerator();
        cachedUidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner);
        return cachedUidGenerator;
    }
}