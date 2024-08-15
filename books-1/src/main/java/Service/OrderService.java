package Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }
    
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}

