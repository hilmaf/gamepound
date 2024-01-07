import React from 'react';
import ProjectBoxInfo from '../../component/project/ProjectBoxInfo';
import styled from 'styled-components';
import ProfileArea from '../../component/userpage/ProfileArea';

const StyledUserCreatedDiv = styled.div`
`;

const UserCreated = () => {
    return (
        <StyledUserCreatedDiv>
            <ProfileArea />
            <ProjectBoxInfo />
        </StyledUserCreatedDiv>
    );
};

export default UserCreated;