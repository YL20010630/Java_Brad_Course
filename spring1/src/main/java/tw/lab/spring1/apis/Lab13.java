package tw.lab.spring1.apis;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/*
	將會員大頭貼上傳並儲存至資料庫中的 BLOB 欄位
 */

@RestController
@RequestMapping("/lab13")
public class Lab13 {

    private final ReadProperties readProperties;
	@Autowired
	private NamedParameterJdbcTemplate jdbc;

    Lab13(ReadProperties readProperties) {
        this.readProperties = readProperties;
    }
	
	@PostMapping("/member/{id}")
//	@PathVariable Integer id：從 URL /member/3 抓取 ID
	public void test1(@PathVariable Integer id, 
			@RequestParam MultipartFile upload) {
//			@RequestParam MultipartFile upload：接收上傳檔案
		
		try {
			byte[] bytes = upload.getBytes();
			String sql = "UPDATE member SET icon = :icon WHERE id = :id";
			
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("icon", bytes);
			params.put("id", id);
			
			int n = jdbc.update(sql, params);
			System.out.println(n > 0);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@PostMapping("/member")		// 接收表單
	public void test1(@ModelAttribute MemberForm memberForm) {
		System.out.println(memberForm.getAccount());
		System.out.println(memberForm.getFiles().size());
		System.out.println(readProperties.getUploadDir());
		
		File here = new File(".");
		System.out.println(here.getAbsolutePath());
		
		String uploadDir = here.getAbsolutePath() +  "/" + readProperties.getUploadDir();
		System.out.println(uploadDir);
		
		List<MultipartFile> files = memberForm.getFiles();
		for (MultipartFile file: files) {
			if (!file.isEmpty()) {
				System.out.println(uploadDir + file.getOriginalFilename());
				String fname = uploadDir + file.getOriginalFilename();
				try {
					file.transferTo(new File(fname));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
