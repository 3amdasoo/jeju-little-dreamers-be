package samdasu.jejuddai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import samdasu.jejuddai.entity.Menu;
import samdasu.jejuddai.entity.Review;
import samdasu.jejuddai.entity.Store;
import samdasu.jejuddai.service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // 위치 기반 스토어 정보 전달
    @GetMapping("/search")
    public List<Store> getStoresByCategoryAndLocation(
//        @RequestParam(value = "category") String category,
        @RequestParam(value = "latitude") double latitude,
        @RequestParam(value = "longitude") double longitude,
        @RequestParam(value = "range") double range) {
//        return storeService.getStoreByCategoryAndLocation(category, latitude, longitude, range);

        return storeService.getStoreByCategoryAndLocation(latitude, longitude, range);

    }

    // 스토어 메뉴 정보 전달
    @GetMapping("/menu")
    public List<Menu> getMenusByStoreId(@RequestParam(value = "storeId") String storeId) {
        return storeService.getMenuByStoreId(storeId);
    }

    // 스토어 리뷰 정보 전달
    @GetMapping("/review")
    public List<Review> getReviewsByStoreId(@RequestParam(value = "storeId") String storeId) {
        return storeService.getReviewByStoreId(storeId);
    }

    //TODO: 수정해야함.
}
