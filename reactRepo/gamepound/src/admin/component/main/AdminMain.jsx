import React from 'react';
import styled from 'styled-components';
import AdminLogin from '../common/AdminLogin';
import BackerMain from '../../pages/backer/BackerMain';
import CategoryMain from '../../pages/category/CategoryMain';
import PaymentMain from '../../pages/payment/PaymentMain';
import ProjectMain from '../../pages/project/ProjectMain';
import UserMain from '../../pages/user/UserMain';
import { Route, Routes } from 'react-router-dom';

const StyledMainDiv = styled.div`

`;

const AdminMain = () => {
    return (
        <div>
            <StyledMainDiv>
                <Routes>
                    <Route path='/' element={<AdminLogin />}></Route>
                    <Route path='/backer/*' element={<BackerMain />}></Route>
                    <Route path='/category/*' element={<CategoryMain />}></Route>
                    <Route path='/payment/*' element={<PaymentMain />}></Route>
                    <Route path='/project/*' element={<ProjectMain />}></Route>
                    <Route path='/user/*' element={<UserMain/>}/>
                </Routes>
            </StyledMainDiv>
        </div>
    );
};

export default AdminMain;