package ck.tools.uid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xfvape.uid.worker.dao.WorkerNodeDAO;
import com.xfvape.uid.worker.entity.WorkerNodeEntity;

@Component
public class WorkerNodeDao implements WorkerNodeDAO{

    @Autowired
    private WorkerNodeRepository workerNodeRepository;

    @Override
    public WorkerNodeEntity getWorkerNodeByHostPort(String host, String port) {
        WorkerNode workerNode = workerNodeRepository.findByHostAndPort(host, port);
        if (workerNode != null) {
            WorkerNodeEntity entity = new WorkerNodeEntity();
            entity.setId(workerNode.getId());
            entity.setHostName(host);
            entity.setPort(workerNode.getPort());
            entity.setType(workerNode.getType());
            entity.setLaunchDateDate(workerNode.getLaunchDate());
            entity.setModified(workerNode.getModified());
            entity.setCreated(workerNode.getCreated());
            return entity;
        }
        return null;
    }

    @Override
    public void addWorkerNode(WorkerNodeEntity workerNodeEntity) {
        WorkerNode workerNode = new WorkerNode();
        workerNode.setHost(workerNodeEntity.getHostName());
        workerNode.setPort(workerNodeEntity.getPort());
        workerNode.setType(workerNodeEntity.getType());
        workerNode.setLaunchDate(workerNodeEntity.getLaunchDate());
        workerNode.setModified(workerNodeEntity.getModified());
        workerNode.setCreated(workerNodeEntity.getCreated());
        workerNodeRepository.save(workerNode);
    }
    
}
