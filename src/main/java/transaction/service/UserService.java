package transaction.service;

/**
 * @author zhaihs
 * @date 2019/11/6
 */
public interface UserService {
    /**
     * transfer
     *
     * @param inName name of save
     * @param outName name of draw
     * @param money quantity of money
     * @throws Exception
     */
    void transfer(String inName, String outName, int money) throws Exception;
}
