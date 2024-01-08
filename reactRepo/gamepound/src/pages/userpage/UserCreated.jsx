import React from 'react';
import ProjectBoxInfo from '../../component/project/ProjectBoxInfo';
import styled from 'styled-components';
import ProfileMenu from '../../component/userpage/ProfileMenu';

const StyledUserCreatedDiv = styled.div`

    #main_wrap {
        padding-left: 20px;

        & > #cnt {
            height: 80px;
            line-height: 80px;
        }

        & > #project_items {
            width: 1050px;
            display: grid;
            grid-template-columns: 1fr 1fr 1fr;
        }
    }
`;

const UserCreated = () => {
    return (
        <StyledUserCreatedDiv>
            <ProfileMenu />
            <div id="main_wrap">
                <div id="cnt">프로젝트가 --n--개 있습니다.</div>
                <div id="project_items">
                    <ProjectBoxInfo />
                    <ProjectBoxInfo />
                    <ProjectBoxInfo />
                </div>
            </div>
        </StyledUserCreatedDiv>
    );
};

export default UserCreated;