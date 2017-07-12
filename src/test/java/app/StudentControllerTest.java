package app;

import app.controllers.StudentController;

import app.configuration.DatabaseConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    @InjectMocks
    private StudentController StudentControllerFixture;

    @Mock
    ArrayList studentListMock;
    @Mock
    Statement stmtMock;
    @Mock
    ResultSet rsMock;
    @Mock
    DatabaseConf databaseConfMock;
    @Mock
    Connection cMock;


    @Test
    public void happyFlowAvailableConsultant() throws Exception {

        when(databaseConfMock.getConnection()).thenReturn(cMock);
        when(cMock.createStatement()).thenReturn(stmtMock);
        when(stmtMock.executeQuery(any(String.class))).thenReturn(rsMock);
        when(rsMock.next()).thenReturn(true,false);

        StudentControllerFixture.student();

        verify(cMock).createStatement();
        verify(stmtMock).executeQuery(any(String.class));
        verify(rsMock,times(2)).next();
        verify(rsMock).getInt("id");
        verify(rsMock).getString("name");
        verify(rsMock).getString("birth_date");
        verify(studentListMock).add(any(String.class));
        assertEquals(StudentControllerFixture.student(), studentListMock);
    }
}