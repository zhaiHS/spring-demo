package transaction.dao;

/**
 * @author zhaihs
 * @date 2019/11/6
 */
public interface UserDao {

    /**
     * draw money
     *
     * @param name
     * @param money
     */
    void out(String name, Integer money);

    /**
     * save money
     *
     * @param name
     * @param money
     */
    void in(String name, Integer money);

    /**
     * get balance of this account
     * @param name name of account
     * @return balance of account
     */
    Long getBalance(String name);
}
