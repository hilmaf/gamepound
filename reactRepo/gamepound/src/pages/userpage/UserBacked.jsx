import React from 'react';
import styled from 'styled-components';
import ProfileMenu from '../../component/userpage/ProfileMenu';

const StyledUserBackedDiv = styled.div`
    
`;

const UserBacked = () => {
    return (
        <StyledUserBackedDiv>
            <ProfileMenu />
            <div id="main_wrap">
                <div id="cnt">--n--건의 후원 내역이 있습니다.</div>
                
            </div>
        </StyledUserBackedDiv>
    );
};

export default UserBacked;