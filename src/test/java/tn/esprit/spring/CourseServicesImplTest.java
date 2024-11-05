import tn.esprit.spring.services.CourseServicesImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.entities.Course;
import tn.esprit.spring.repositories.ICourseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CourseServicesImplTest {

    @Mock
    private ICourseRepository courseRepository;

    @InjectMocks
    private CourseServicesImpl courseServices;

    private Course course;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        course = new Course();
        course.setNumCourse(1L);
        course.setLevel(1);
        course.setPrice(100.0f);
        // Set other fields as needed
    }

    @Test
    void testRetrieveAllCourses() {
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course));

        List<Course> courses = courseServices.retrieveAllCourses();

        assertNotNull(courses);
        assertEquals(1, courses.size());
        verify(courseRepository, times(1)).findAll();
    }

    @Test
    void testAddCourse() {
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course savedCourse = courseServices.addCourse(course);

        assertNotNull(savedCourse);
        assertEquals(course.getNumCourse(), savedCourse.getNumCourse());
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testUpdateCourse() {
        when(courseRepository.save(any(Course.class))).thenReturn(course);

        Course updatedCourse = courseServices.updateCourse(course);

        assertNotNull(updatedCourse);
        assertEquals(course.getNumCourse(), updatedCourse.getNumCourse());
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    void testRetrieveCourseById() {
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        Course retrievedCourse = courseServices.retrieveCourse(1L);

        assertNotNull(retrievedCourse);
        assertEquals(course.getNumCourse(), retrievedCourse.getNumCourse());
        verify(courseRepository, times(1)).findById(1L);
    }
}
