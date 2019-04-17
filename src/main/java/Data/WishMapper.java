package Data;

import Logic.DTO.Wish;
import Logic.Exceptions.WishSampleException;

/**
 *
 * @author martin
 */
public interface WishMapper
{
    void createOrder(Wish order) throws WishSampleException;
}
