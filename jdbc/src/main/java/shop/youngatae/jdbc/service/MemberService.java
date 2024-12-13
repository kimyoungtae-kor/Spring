package shop.youngatae.jdbc.service;



import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import shop.youngatae.jdbc.dao.MemberDao;
import shop.youngatae.jdbc.dao.PostDao;
import shop.youngatae.jdbc.dao.ReplyDao;

@AllArgsConstructor
@Service
public class MemberService {
  private MemberDao memberDao;
  private PostDao postDao;
  private ReplyDao replyDao;
  private DataSourceTransactionManager manager;
  private TransactionDefinition definition;


  // public void quitMember(String id){
  //   TransactionStatus status = manager.getTransaction(definition);
  //   manager.commit(status);
  //   manager.rollback(status);

  //   try{
  //     replyDao.updateToWriterNull(id);
  //     postDao.updateToWriterNull(id);
  //     memberDao.delete(id);
  //     manager.commit(status);
  //   }catch(DataAccessException e){
  //     manager.rollback(status);
  //   }
    
  // }
  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
  public void quitMember(String id){
      replyDao.updateToWriterNull(id);
      postDao.updateToWriterNull(id);
      memberDao.delete(id);
  }
}
