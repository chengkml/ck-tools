package ck.tools.uid;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerNodeRepository extends JpaRepository<WorkerNode, Long> {

    WorkerNode findByHostAndPort(String host, String port);
}
