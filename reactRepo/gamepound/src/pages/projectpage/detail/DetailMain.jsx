import React from 'react';
import CommunityPage from "./CommunityPage";
import StoryPage from "./StoryPage";
import UpdatePage from "./UpdatePage";
import { Route, Routes } from 'react-router-dom';
import PrelaunchDetailMain from './PrelaunchDetailMain';

const DetailMain = () => {
    return (<>
        <Routes>
            <Route path='/community' element={<CommunityPage/>}></Route>
            <Route path='/story' element={<StoryPage/>}></Route>
            <Route path='/update' element={<UpdatePage/>}></Route>
            <Route path='/prelaunch/*' element={<PrelaunchDetailMain/>}></Route>
        </Routes>              
    </>);
};

export default DetailMain;