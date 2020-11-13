package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import domain.Money;
import domain.MoneyExample;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    long countByExample(MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    int deleteByExample(MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    int deleteByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    int insert(Money record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    int insertSelective(Money record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    List<Money> selectByExample(MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    Money selectByPrimaryKey(Integer uid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    int updateByExampleSelective(@Param("record") Money record, @Param("example") MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    int updateByExample(@Param("record") Money record, @Param("example") MoneyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    int updateByPrimaryKeySelective(Money record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money
     *
     * @mbg.generated Sun Oct 06 23:25:49 CST 2019
     */
    int updateByPrimaryKey(Money record);


    // ---
    void updateMoneyWithIncrese(@Param("uid") Integer uid,@Param("money") Double money);


    void updateMoneyWithReduce(@Param("uid") Integer uid,@Param("money") Double money);
}