package app;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import app.configuration.DatabaseConf;
import app.controllers.SchoolController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@RunWith(MockitoJUnitRunner.class)
public class SchoolControllerTest {

    @InjectMocks
    private SchoolController SchoolControllerFixture;

    @Mock
    ArrayList schoolListMock;
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

        SchoolControllerFixture.school();

        verify(cMock).createStatement();
        verify(stmtMock).executeQuery(any(String.class));
        verify(rsMock,times(2)).next();
        verify(rsMock).getInt("id");
        verify(rsMock).getString("city");
        verify(rsMock).getString("name");
        verify(schoolListMock).add(any(String.class));
        assertEquals(SchoolControllerFixture.school(), schoolListMock);
    }
        }