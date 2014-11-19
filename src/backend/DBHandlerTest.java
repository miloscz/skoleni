package backend;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import com.mongodb.util.JSON;

public class DBHandlerTest {

	@Before
	public void setUp() throws Exception {
		DBHandler handler = DBHandler.getInstance();
		String body = "{ \"firstName\": \"Andrea\", \"surname\": \"Novotna\", \"age\": \"19\", \"height\": \"150\", \"weight\": \"50\", \"votes\": \"0\", \"parameters\":{ \"chest\": \"200\", \"waist\": \"20\", \"hips\": \"100\" }";
		String candidate = handler.createCandidate(body);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCandidates() {
		fail("Not yet implemented");
	}

	@Test
	public void testVote() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCandidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateCandidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveCandidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCandidate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

}
